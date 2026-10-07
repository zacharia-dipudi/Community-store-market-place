package za.ac.cput.communitystoremarketplace.Controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.communitystoremarketplace.Domain.Favorite;
import za.ac.cput.communitystoremarketplace.Service.FavoriteService;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/create")
    public Favorite create(@RequestBody Favorite favorite) {
        return favoriteService.create(favorite);
    }

    @GetMapping("/read")
    public Favorite read(@RequestParam Long favoriteId) {
        return favoriteService.read(favoriteId);
    }

    @PutMapping("/update")
    public Favorite update(@RequestBody Favorite favorite) {
        return favoriteService.update(favorite);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Long favoriteId) {
        return favoriteService.delete(favoriteId);
    }

    @GetMapping("/getAll")
    public List<Favorite> getAll() {
        return favoriteService.getAll();
    }

    @GetMapping("/getByUser")
    public List<Favorite> getByUser(@RequestParam Long userId) {
        return favoriteService.getByUserId(userId);
    }
}
