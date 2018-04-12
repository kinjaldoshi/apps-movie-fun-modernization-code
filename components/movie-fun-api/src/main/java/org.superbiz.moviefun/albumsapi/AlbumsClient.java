package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class AlbumsClient {


    private String albumsUrl;
    private RestOperations restOperations;

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum (AlbumInfo albumInfo){
        System.out.println(albumInfo.toString());
        restOperations.postForEntity(albumsUrl, albumInfo, AlbumInfo.class);
    }

    public AlbumInfo find(long albumId){
        return restOperations.getForEntity(albumsUrl + "/" + albumId, AlbumInfo.class).getBody();
    }

    public List<AlbumInfo> getAlbums(){
        ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
        };
        return restOperations.exchange(albumsUrl, HttpMethod.GET, null, albumListType).getBody();
    }
}
