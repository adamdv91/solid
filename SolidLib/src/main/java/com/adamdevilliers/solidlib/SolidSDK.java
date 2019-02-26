package com.adamdevilliers.solidlib;

import com.adamdevilliers.solidlib.api.SolidClient;
import com.adamdevilliers.solidlib.api.response.models.Cities;
import com.adamdevilliers.solidlib.api.response.models.Malls;
import com.adamdevilliers.solidlib.api.response.models.Shops;

import java.util.List;

public interface SolidSDK {

    void getCities(final SolidCallback<List<Cities>> callback);

    void getCity(final int cityId, final SolidCallback<Cities> callback);

    void getMalls(final int cityId, final SolidCallback<List<Malls>> callback);

    void getMall(final int cityId, final int mallId, final SolidCallback<Malls> callback);

    void getShops(final int mallId, final SolidCallback<List<Shops>> callback);

    void getShopsForCity(final int cityId, final SolidCallback<List<Shops>> callback);

    void getShop(final int mallId, final int shopId, final SolidCallback<Shops> callback);

    /*
        Solid sdk builder is used for instantiation of the solidSdk interface
     */

    class Builder {
        public SolidSDK build() {
            return new Solid(new SolidClient());
        }
    }
}
