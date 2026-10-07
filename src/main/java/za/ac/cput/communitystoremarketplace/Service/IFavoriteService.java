package za.ac.cput.communitystoremarketplace.Service;

import za.ac.cput.communitystoremarketplace.Domain.Favorite;

import java.util.List;

public interface IFavoriteService extends IService<Favorite, Long> {
    List<Favorite> getAll();
    List<Favorite> getByUserId(Long userId);
}
