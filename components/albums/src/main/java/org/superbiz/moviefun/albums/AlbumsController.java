package org.superbiz.moviefun.albums;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository){
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album){
        System.out.println(album.toString());
        albumsRepository.addAlbum(album);
    }

    @GetMapping("/{albumId}")
    public Album getAlbum(@PathVariable(name = "albumId") long albumId){
        return albumsRepository.find(albumId);
    }

    @GetMapping
    public List<Album> getAlbums(){
        return albumsRepository.getAlbums();
    }

}
