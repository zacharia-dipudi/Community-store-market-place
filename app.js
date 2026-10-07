/* Community Store – front-end prototype (no backend; data saved in localStorage) */
const $ = (s, e = document) => e.querySelector(s);
const store = {
  get: (k, d) => { try { return JSON.parse(localStorage.getItem(k)) ?? d; } catch { return d; } },
  set: (k, v) => localStorage.setItem(k, JSON.stringify(v)),
};
const R = n => 'R' + Number(n).toLocaleString('en-ZA');
const esc = s => String(s).replace(/[&<>"']/g, c => ({ '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' }[c]));
const stars = r => '★'.repeat(Math.round(r)) + '☆'.repeat(5 - Math.round(r));

const CATS = { Books: '#2a6fdb', Electronics: '#7a4fd1', Food: '#e0782b', Furniture: '#8a6a3b', Services: '#0f8f7a', Clothing: '#d1457a' };
const ROLES = { student: 'Student', faculty: 'Faculty', vendor: 'Local vendor', resident: 'Resident' };

const seed = {
  products: [
    { id: 1, title: 'Calculus textbook (8th ed.)', price: 350, cat: 'Books', emoji: '📘', seller: 'Thandi M.', type: 'student', verified: true, desc: 'Light highlighting in chapters 1–4. Collect on campus.', reviews: [{ by: 'Sipho', r: 5, t: 'Exactly as described.' }] },
    { id: 2, title: 'Refurbished laptop, 8GB RAM', price: 3800, cat: 'Electronics', emoji: '💻', seller: 'TechFix Corner', type: 'vendor', verified: true, desc: '6-month warranty, battery replaced.', reviews: [{ by: 'Lerato', r: 4, t: 'Fast and fair.' }, { by: 'Ayanda', r: 5, t: 'Great value.' }] },
    { id: 3, title: 'Homemade koeksisters (box of 12)', price: 90, cat: 'Food', emoji: '🍩', seller: 'Aunty Noni', type: 'resident', verified: false, desc: 'Baked fresh on Fridays. Pre-order by Thursday.', reviews: [] },
    { id: 4, title: 'Desk and chair set', price: 650, cat: 'Furniture', emoji: '🪑', seller: 'Dr. Naidoo', type: 'faculty', verified: true, desc: 'Moving out. Must collect from residence.', reviews: [{ by: 'Kea', r: 4, t: 'Sturdy.' }] },
    { id: 5, title: 'Maths tutoring, per hour', price: 120, cat: 'Services', emoji: '🧮', seller: 'Brandon K.', type: 'student', verified: true, desc: 'Year 1–2 maths and stats. Evenings or weekends.', reviews: [{ by: 'Zoe', r: 5, t: 'Made integrals click.' }] },
    { id: 6, title: 'Campus hoodie, size M', price: 220, cat: 'Clothing', emoji: '🧥', seller: 'Print Shack', type: 'vendor', verified: true, desc: 'Official colours, brushed inside.', reviews: [] },
  ],
  posts: [
    { id: 1, kind: 'Event', title: 'Saturday second-hand market', body: 'Student union lawn, 9:00–14:00. Free stalls for verified sellers.', by: 'Student Council' },
    { id: 2, kind: 'Notice', title: 'Vendor verification open', body: 'Local vendors can submit trading documents at the community desk.', by: 'Admin' },
    { id: 3, kind: 'Service', title: 'Lift club to town', body: 'Weekday mornings from residence. Share the fuel cost.', by: 'Neighbour Watch' },
  ],
  notes: [{ id: 1, text: 'Welcome! Sign in with your university email to start trading.', read: false }],
};

const S = {
  tab: 'shop', q: '', cat: 'All', sort: 'new', verified: false,
  products: store.get('products', seed.products),
  posts: store.get('posts', seed.posts),
  notes: store.get('notes', seed.notes),
  cart: store.get('cart', {}),
  user: store.get('user', null),
};
const save = () => ['products', 'posts', 'notes', 'cart', 'user'].forEach(k => store.set(k, S[k]));
const avg = p => p.reviews.length ? p.reviews.reduce((a, r) => a + r.r, 0) / p.reviews.length : 0;
const nextId = a => Math.max(0, ...a.map(x => x.id)) + 1;

function toast(msg) {
  const t = $('#toast'); t.textContent = msg; t.classList.add('show');
  clearTimeout(toast.t); toast.t = setTimeout(() => t.classList.remove('show'), 2200);
}
function notify(text) { S.notes.unshift({ id: nextId(S.notes), text, read: false }); save(); }

/* ---------- Views ---------- */
const views = {
  shop() {
    let list = S.products.filter(p =>
      (S.cat === 'All' || p.cat === S.cat) &&
      (!S.verified || p.verified) &&
      (p.title + p.seller + p.desc).toLowerCase().includes(S.q.toLowerCase()));
    if (S.sort === 'low') list.sort((a, b) => a.price - b.price);
    if (S.sort === 'high') list.sort((a, b) => b.price - a.price);
    if (S.sort === 'rated') list.sort((a, b) => avg(b) - avg(a));
    if (S.sort === 'new') list.sort((a, b) => b.id - a.id);
    return `
    <div class="stack">
      <div class="row between"><h2>Shop</h2><button class="btn" data-act="sell">+ Sell</button></div>
      <input type="search" id="q" placeholder="Search textbooks, tutoring, food…" value="${esc(S.q)}" aria-label="Search">
      <div class="scroll">${['All', ...Object.keys(CATS)].map(c => `<button class="chip ${S.cat === c ? 'on' : ''}" data-act="cat" data-v="${c}">${c}</button>`).join('')}</div>
      <div class="row">
        <select id="sort" aria-label="Sort"><option value="new">Newest</option><option value="low">Price: low to high</option><option value="high">Price: high to low</option><option value="rated">Best rated</option></select>
        <label class="row" style="margin:0;white-space:nowrap"><input type="checkbox" id="ver" style="width:auto" ${S.verified ? 'checked' : ''}> Verified only</label>
      </div>
    </div>
    ${list.length ? `<div class="grid">${list.map(card).join('')}</div>` : `<p class="empty">No listings match. Try another search or clear the filters.</p>`}`;
  },

  board() {
    const col = { Event: '#0f8f7a', Notice: '#d8452f', Service: '#2a6fdb' };
    return `<div class="stack">
      <h2>Community board</h2>
      <div class="card stack">
        <h3>Post to the board</h3>
        <select id="pk"><option>Event</option><option>Notice</option><option>Service</option></select>
        <input id="pt" placeholder="Title" maxlength="60">
        <textarea id="pb" rows="2" placeholder="Details"></textarea>
        <button class="btn" data-act="post">Post</button>
      </div>
      ${S.posts.map(p => `<article class="card post" style="--c:${col[p.kind]}"><span class="kind">${p.kind}</span><h3>${esc(p.title)}</h3><p>${esc(p.body)}</p><p class="muted">Posted by ${esc(p.by)}</p></article>`).join('')}
    </div>`;
  },

  cart() {
    const rows = Object.entries(S.cart).map(([id, q]) => ({ p: S.products.find(p => p.id == id), q })).filter(r => r.p);
    if (!rows.length) return `<h2>Cart</h2><p class="empty">Your cart is empty.<br><br><button class="btn" data-act="goto" data-tab="shop">Browse listings</button></p>`;
    const total = rows.reduce((a, r) => a + r.p.price * r.q, 0);
    return `<div class="stack"><h2>Cart</h2>
      ${rows.map(({ p, q }) => `<div class="card row between"><div><h3>${p.emoji} ${esc(p.title)}</h3><p class="muted">${esc(p.seller)} · ${R(p.price)}</p></div>
        <div class="row qty"><button data-act="qty" data-id="${p.id}" data-d="-1" aria-label="Remove one">−</button><b>${q}</b><button data-act="qty" data-id="${p.id}" data-d="1" aria-label="Add one">+</button></div></div>`).join('')}
      <div class="card stack">
        <div class="row between"><h3>Total</h3><h3>${R(total)}</h3></div>
        <div><label for="pay">Pay with</label><select id="pay"><option>Card (secure checkout)</option><option>Instant EFT</option><option>Cash on campus pickup</option></select></div>
        <button class="btn full" data-act="checkout">Pay ${R(total)}</button>
        <p class="muted">Prototype only: no real payment is taken.</p>
      </div></div>`;
  },

  alerts() {
    const html = `<div class="stack"><div class="row between"><h2>Alerts</h2><button class="chip" data-act="readall">Mark all read</button></div>
      ${S.notes.length ? S.notes.map(n => `<div class="card note ${n.read ? '' : 'new'}"><span>${n.read ? '🔔' : '🔶'}</span><p>${esc(n.text)}</p></div>`).join('') : '<p class="empty">Nothing yet.</p>'}</div>`;
    return html;
  },

  me() {
    const u = S.user;
    if (u) return `<div class="stack"><h2>Hi, ${esc(u.name)}</h2>
      <div class="card stack"><p><b>${ROLES[u.role]}</b> · ${esc(u.email)}</p>
      ${u.role === 'vendor' ? `<p class="warn">Vendor verification: ${u.verified ? 'verified ✓' : 'pending. Visit the community desk with your trading documents.'}</p>` : u.verified ? '<p class="ok">✓ University email verified</p>' : ''}
      <button class="btn alt" data-act="signout">Sign out</button></div>
      <div class="card"><h3>Your listings</h3>${S.products.filter(p => p.seller === u.name).map(p => `<p>${p.emoji} ${esc(p.title)} · ${R(p.price)}</p>`).join('') || '<p class="muted">You have not listed anything yet.</p>'}</div></div>`;
    return `<div class="stack"><h2>Join the community</h2>
      <div class="card stack">
        <div><label for="rn">Name</label><input id="rn" autocomplete="name"></div>
        <div><label for="rr">I am a</label><select id="rr">${Object.entries(ROLES).map(([k, v]) => `<option value="${k}">${v}</option>`).join('')}</select></div>
        <div><label for="re">Email</label><input id="re" type="email" autocomplete="email" placeholder="you@university.ac.za"></div>
        <p class="muted">Students and faculty must use a university email (.ac.za or .edu).</p>
        <button class="btn full" data-act="signin">Create account</button>
      </div></div>`;
  },
};

function card(p) {
  return `<button class="item" data-act="open" data-id="${p.id}" style="--c:${CATS[p.cat]}">
    <div class="pic">${p.emoji}</div>
    <div class="info"><h3>${esc(p.title)}</h3><span class="price">${R(p.price)}</span>
    <span class="stars" aria-label="${avg(p).toFixed(1)} of 5">${p.reviews.length ? stars(avg(p)) + ' (' + p.reviews.length + ')' : 'No reviews yet'}</span>
    <span class="muted">${esc(p.seller)} ${p.verified ? '<span class="ok">✓ verified</span>' : ''}</span></div></button>`;
}

/* ---------- Render ---------- */
function render() {
  $('#view').innerHTML = views[S.tab]();
  document.querySelectorAll('.tabs button').forEach(b => b.classList.toggle('on', b.dataset.tab === S.tab));
  $('#who').textContent = S.user ? S.user.name.split(' ')[0] : 'Sign in';
  const cartN = Object.values(S.cart).reduce((a, b) => a + b, 0), unread = S.notes.filter(n => !n.read).length;
  $('#cartBadge').textContent = cartN; $('#cartBadge').classList.toggle('show', cartN > 0);
  $('#noteBadge').textContent = unread; $('#noteBadge').classList.toggle('show', unread > 0);
  const sort = $('#sort'); if (sort) sort.value = S.sort;
}

function openProduct(id) {
  const p = S.products.find(x => x.id == id), m = $('#modal');
  m.style.setProperty('--c', CATS[p.cat]);
  m.innerHTML = `<div class="stack">
    <div class="big">${p.emoji}</div>
    <div class="row between"><h2 style="margin:0">${esc(p.title)}</h2><span class="price">${R(p.price)}</span></div>
    <p>${esc(p.desc)}</p>
    <p class="muted">Sold by <b>${esc(p.seller)}</b> (${ROLES[p.type]}) ${p.verified ? '<span class="ok">✓ verified</span>' : '<span class="muted">· not yet verified</span>'}</p>
    <button class="btn full" data-act="add" data-id="${p.id}">Add to cart</button>
    <h3>Reviews ${p.reviews.length ? `<span class="stars">${stars(avg(p))}</span>` : ''}</h3>
    ${p.reviews.map(r => `<div class="card"><span class="stars">${stars(r.r)}</span> <b>${esc(r.by)}</b><p>${esc(r.t)}</p></div>`).join('') || '<p class="muted">Be the first to review this seller.</p>'}
    <div class="card stack"><label for="rs">Your rating</label>
      <select id="rs">${[5, 4, 3, 2, 1].map(n => `<option value="${n}">${n} – ${stars(n)}</option>`).join('')}</select>
      <input id="rt" placeholder="Write a short review" maxlength="140">
      <button class="btn alt" data-act="review" data-id="${p.id}">Submit review</button></div>
    <button class="chip" data-act="close">Close</button></div>`;
  m.showModal();
}

function openSell() {
  if (!S.user) { toast('Sign in first to sell'); S.tab = 'me'; return render(); }
  const m = $('#modal');
  m.innerHTML = `<div class="stack"><h2>New listing</h2>
    <div><label for="st">Title</label><input id="st" maxlength="60"></div>
    <div><label for="sp">Price (R)</label><input id="sp" type="number" min="0"></div>
    <div><label for="sc">Category</label><select id="sc">${Object.keys(CATS).map(c => `<option>${c}</option>`).join('')}</select></div>
    <div><label for="sd">Description</label><textarea id="sd" rows="3"></textarea></div>
    <button class="btn full" data-act="publish">Publish listing</button>
    <button class="chip" data-act="close">Cancel</button></div>`;
  m.showModal();
}

/* ---------- Events ---------- */
const val = id => $('#' + id).value.trim();
const EMOJI = { Books: '📚', Electronics: '🔌', Food: '🍲', Furniture: '🛋️', Services: '🛠️', Clothing: '👕' };

const actions = {
  goto: d => { S.tab = d.tab; if (d.tab === 'alerts') { render(); S.notes.forEach(n => n.read = true); save(); setTimeout(render, 1200); return; } render(); },
  cat: d => { S.cat = d.v; render(); },
  open: d => openProduct(d.id),
  close: () => $('#modal').close(),
  sell: openSell,
  add: d => { S.cart[d.id] = (S.cart[d.id] || 0) + 1; save(); $('#modal').close(); render(); toast('Added to cart'); },
  qty: d => { const q = (S.cart[d.id] || 0) + Number(d.d); if (q <= 0) delete S.cart[d.id]; else S.cart[d.id] = q; save(); render(); },
  checkout: () => {
    if (!S.user) { toast('Sign in to check out'); S.tab = 'me'; return render(); }
    const n = Object.keys(S.cart).length;
    notify(`Order placed for ${n} item${n > 1 ? 's' : ''}. Sellers have been notified.`);
    S.cart = {}; save(); S.tab = 'alerts'; render(); toast('Payment successful');
  },
  readall: () => { S.notes.forEach(n => n.read = true); save(); render(); },
  post: () => {
    if (!S.user) { toast('Sign in to post'); S.tab = 'me'; return render(); }
    if (!val('pt') || !val('pb')) return toast('Add a title and details');
    S.posts.unshift({ id: nextId(S.posts), kind: val('pk'), title: val('pt'), body: val('pb'), by: S.user.name });
    save(); render(); toast('Posted');
  },
  review: d => {
    if (!S.user) return toast('Sign in to leave a review');
    if (!val('rt')) return toast('Write a short review first');
    S.products.find(p => p.id == d.id).reviews.push({ by: S.user.name, r: Number(val('rs')), t: val('rt') });
    save(); render(); openProduct(d.id); toast('Review added');
  },
  publish: () => {
    if (!val('st') || !(Number(val('sp')) >= 0) || val('sp') === '') return toast('Add a title and price');
    const c = val('sc');
    S.products.push({ id: nextId(S.products), title: val('st'), price: Number(val('sp')), cat: c, emoji: EMOJI[c], seller: S.user.name, type: S.user.role, verified: S.user.verified, desc: val('sd') || 'No description.', reviews: [] });
    save(); $('#modal').close(); S.tab = 'shop'; render(); toast('Listing published');
  },
  signin: () => {
    const name = val('rn'), role = val('rr'), email = val('re').toLowerCase();
    if (!name || !/^\S+@\S+\.\S+$/.test(email)) return toast('Enter your name and a valid email');
    const uni = /\.(ac\.[a-z]{2}|edu)$/.test(email);
    if ((role === 'student' || role === 'faculty') && !uni) return toast('Use your university email (.ac.za or .edu)');
    S.user = { name, role, email, verified: uni };
    notify(role === 'vendor' ? 'Vendor account created. Verification is pending.' : `Welcome, ${name}!`);
    save(); render(); toast('Account created');
  },
  signout: () => { S.user = null; save(); render(); },
};

document.addEventListener('click', e => {
  const el = e.target.closest('[data-act]');
  if (el && actions[el.dataset.act]) actions[el.dataset.act](el.dataset);
});
document.addEventListener('input', e => {
  if (e.target.id === 'q') { S.q = e.target.value; const pos = e.target.selectionStart; render(); const q = $('#q'); q.focus(); q.setSelectionRange(pos, pos); }
});
document.addEventListener('change', e => {
  if (e.target.id === 'sort') { S.sort = e.target.value; render(); }
  if (e.target.id === 'ver') { S.verified = e.target.checked; render(); }
});
$('#modal').addEventListener('click', e => { if (e.target.id === 'modal') e.target.close(); });

render();
