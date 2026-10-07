package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Favorite;

import java.util.Date;

public class FavoriteFactory {
    public static Favorite createFavorite(Long favoriteId, Long userId, Long productId, Date favoriteDate) {

        if (userId != null && productId != null) {

            return new Favorite.Builder()
                    .setFavoriteId(favoriteId)
                    .setUserId(userId)
                    .setProductId(productId)
                    .setFavoriteDate(favoriteDate != null ? favoriteDate : new Date())
                    .build();
        }
        return null;
    }
}
