package org.mp4parser.muxer;

import org.mp4parser.muxer.container.mp4.MovieCreator;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;


public class InTestMovieCreator {
    public static Movie createMovieOnlyVideo(String... names) throws IOException {
        Movie m = new Movie();
        for (String name : names) {
            Movie m1 = MovieCreator.build((URLDecoder.decode(InTestMovieCreator.class.getProtectionDomain().getCodeSource().getLocation().getFile(), StandardCharsets.UTF_8.name()) + name));
            for (Track track : m1.getTracks()) {
                if ("vide".equals(track.getHandler())) {
                    m.addTrack(track);
                }
            }

        }
        return m;
    }

}
