package tn.isetrades.test10.api;

import java.net.URL;
import java.util.List;
import org.openstack4j.model.common.Payload;
import org.openstack4j.model.image.v2.ContainerFormat;
import org.openstack4j.model.image.v2.DiskFormat;
import org.openstack4j.model.image.v2.Image;

/**
 *
 * @author Rania
 */
public interface ImageApi {

    public Image createImage(String name, long mindisk, long minram, Image.ImageVisibility visibility, DiskFormat dFormat);
    public Payload<URL> createPayload(String url);
    
    public List<? extends Image> listAllImages();
    

}
