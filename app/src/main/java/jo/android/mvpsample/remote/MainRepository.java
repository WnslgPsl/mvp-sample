package jo.android.mvpsample.remote;

import jo.android.mvpsample.view.main.data.PhotoResponse;

/**
 * presenter와 연결
 */
public class MainRepository implements MainDataSource {

    private RemoteDataSource remoteDataSource = RemoteDataSource.getRemoteDataSource();

    private MainRepository() {
    }

    private static class FlickrRepositoryHolder{
        public static final MainRepository INSTANCE = new MainRepository();
    }

    public static MainRepository getFlickrRepository() {
        return MainRepository.FlickrRepositoryHolder.INSTANCE;
    }

    @Override
    public void getSearchPhotos(String format, String nojsoncallback, String method, String searchKeyword, String flickrKey,
                                int requestPage, int requestPerPage, final LoadFlickrCallback<PhotoResponse> callback) {

        remoteDataSource.getSearchPhotos(format, nojsoncallback, method, searchKeyword, flickrKey, requestPage, requestPerPage,
                new LoadFlickrCallback<PhotoResponse>() {
            @Override
            public void onSuccess(PhotoResponse photoResponse) {
                callback.onSuccess(photoResponse);
            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        });

    }
}
