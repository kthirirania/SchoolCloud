package tn.isetrades.test10.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.model.common.Payload;
import org.openstack4j.model.common.Payloads;
import org.openstack4j.model.image.v2.ContainerFormat;
import org.openstack4j.model.image.v2.DiskFormat;
import org.openstack4j.model.image.v2.Image;
import org.openstack4j.model.image.v2.Image.ImageVisibility;
import org.openstack4j.openstack.OSFactory;

public class ImageApiImpl implements ImageApi {

    private OSClient.OSClientV3 createOSClientV3() {
        OSFactory.enableHttpLoggingFilter(true);
        Identifier domainIdentifier = Identifier.byId("default");

       OSClient.OSClientV3 os = OSFactory.builderV3()
                .endpoint("http://41.229.118.249/identity/v3")
                .credentials("admin", "secret", domainIdentifier)
                .scopeToProject(Identifier.byName("admin"), Identifier.byName("Default"))
                .authenticate();
        return os;
    }

    @Override
    public Image createImage(String name, long mindisk, long minram, ImageVisibility visibility, DiskFormat dFormat) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Image image = os.imagesV2().create(
                Builders.imageV2()
                        .name(name)
                        .containerFormat(ContainerFormat.BARE)
                        .visibility(visibility)
                        .diskFormat(dFormat)
                        .minDisk(mindisk)
                        .minRam(minram)
                        .build());
        return image;
    }

    @Override
    public Payload<URL> createPayload(String url) {
        Payload<URL> payload = null;
        try {
            payload = Payloads.create(new URL(url));
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageApiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payload;
    }

    public Image getImageById(String imageId) {
        final OSClient.OSClientV3 os = createOSClientV3();
        Image image = os.imagesV2().get(imageId);
        return image;
    }

    public ActionResponse uploadImage(Image image, Payload<URL> payload) {
        final OSClient.OSClientV3 os = createOSClientV3();
        ActionResponse upload = os.imagesV2().upload(image.getId(),payload,image);
        return upload;
    }

    @Override
    public List<? extends Image> listAllImages() {
        final OSClient.OSClientV3 os = createOSClientV3();
        List<? extends Image> images = os.imagesV2().list();
        return images;
    }

}
