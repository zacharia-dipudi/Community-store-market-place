package za.ac.cput.communitystoremarketplace.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.communitystoremarketplace.Domain.Favorite;
import za.ac.cput.communitystoremarketplace.Repository.FavoriteRepository;

import java.util.List;

@Service
public class FavoriteService implements IFavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public List<Favorite> getAll() {
        return favoriteRepository.findAll();
    }

    @Override
    public List<Favorite> getByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    @Override
    public Favorite create(Favorite favorite) {
        // A user can only favorite a product once; return the existing record if present
        return favoriteRepository
                .findByUserIdAndProductId(favorite.getUserId(), favorite.getProductId())
                .orElseGet(() -> favoriteRepository.save(favorite));
    }

    @Override
    public Favorite read(Long favoriteId) {
        return favoriteRepository.findById(favoriteId).orElse(null);
    }

    @Override
    public Favorite update(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public boolean delete(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
        return true;
    }
}
