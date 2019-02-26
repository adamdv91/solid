# **Solid**

The Solid sdk is a library created to grab a few cities based in South Africa, with their malls and certain shops in those malls.

# **Android development**

* Written as a JavaLib
* Uses Retrofit2 to communicate with JSON

# **Development Setup**

Please note; This sdk requires internet access at all times, there is currently no offline mode. The developer will need to add this line to their manifest;

`<uses-permission android:name="android.permission.INTERNET" />`

Once this is done, you can now start to implement the sdk

Initialize the Solid sdk by calling;
`SolidSDK solidSdk = new SolidSDK.Builder().build();`

### **Get Cities**

Once this is done, a developer should be able to start using the requests to grab information.

```
solidSdk.getCities(new SolidCallback<List<City>>() {

            @Override
            public void onSuccess(List<City> data) {
                
                
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
```

### **Get Malls**

To the get the malls in a specific city, pass the cityId to getMalls(). The result in the callback will be a list of all malls that exist in that city. If no malls exist, an exception will be returned on onFailure

For instance, to request the Malls for a city with the ID 1, do the following:

```
solidSdk.getMalls(1, new SolidCallback<List<Mall>>() {
            @Override
            public void onSuccess(List<Mall> data) {                
              
                
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
```

### **Get Shops**

To the get the shops in a specific mall, pass the mallId to getShops(). The result in the callback will be a list of all shops that exist in that mall. If no shops exist, an exception will be returned on onFailure

For instance, to request the Shops for a mall with the ID 1, do the following:

```
solidSdk.getShops(1, new SolidCallback<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> data) {
                
                

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
```

They can also grab each shop that is found per city;

```
solidSdk.getShopsForCity(1, new SolidCallback<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> data) {
                
              
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
```
This will grab each shop based on what you have set the city id to.

### **Getting single value results**

This can be done, if the developer knows which exact results they want, for example;

```
City singleCity = new City();
solidSdk.getCity(1, new SolidCallback<City>() {
            @Override
            public void onSuccess(City data) {
                singleCity = data;
                //Single data can be displayed in a string; singleCity.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
```
This will grab all the information of the city at the id number you allocate. Allocating 1 will grab all the information that city has, at that id point. This can be done with malls and shops as well.

```
solidSdk.getMall(1, 1, new SolidCallback<Mall>() {
            @Override
            public void onSuccess(Mall data) {
                singleMall = data;
                //Single data can be displayed in a string; singleMall.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
```
This will grab the mall at the cityId=1 and where mallId=1. This will allow you to see what shops are in that particular mall, in that particular city.

For shops, something similar will happen; 

```
solidSdk.getShop(1, 1, new SolidCallback<Shop>() {
            @Override
            public void onSuccess(Shop data) {
                singleShop = data;
                //Single data can be displayed in a string; singleShop.getName();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
```
We will grab the mallId first, so the mallId=1 and then the shopId next, shopId=1. This will grab the particular shop, based in a particular mall, for the developer to display. 

# **Ending off**

The SDK gives the developer full range of what he wishes to do with each response, whether it is to display in a recyclerView, spinner or just an arrayList and print a string is up to them.
