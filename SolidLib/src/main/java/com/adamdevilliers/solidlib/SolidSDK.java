package com.adamdevilliers.solidlib;

import com.adamdevilliers.solidlib.api.SolidClient;
import com.adamdevilliers.solidlib.models.City;
import com.adamdevilliers.solidlib.models.Mall;
import com.adamdevilliers.solidlib.models.Shop;

import java.util.List;

public interface SolidSDK {

    void getCities(final SolidCallback<List<City>> callback);

    void getCity(final int cityId, final SolidCallback<City> callback);

    void getMalls(final int cityId, final SolidCallback<List<Mall>> callback);

    void getMall(final int cityId, final int mallId, final SolidCallback<Mall> callback);

    void getShops(final int mallId, final SolidCallback<List<Shop>> callback);

    void getShopsForCity(final int cityId, final SolidCallback<List<Shop>> callback);

    void getShop(final int mallId, final int shopId, final SolidCallback<Shop> callback);

    /*
        Solid sdk builder is used for instantiation of the solidSdk interface
     */

    class Builder {
        public SolidSDK build() {
            return new Solid(new SolidClient());
        }
    }
}
