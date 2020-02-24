package tn.isetrades.test10.entity.service;

import java.util.List;
import tn.isetrades.test10.entity.dao.ImageDao;
import tn.isetrades.test10.entity.model.Image;

/**
 *
 * @author Rania
 */
public class ImageService {
    
     ImageDao imageDAO = new ImageDao();

    public Image createImage(Image r) {
        imageDAO.addImage(r);
        return r;
    }

    public void updateImage(Integer id) {
        Image image = imageDAO.findImageById(id);
        imageDAO.updateImage(image);
    }

    public void deleteImage(Integer id) {
        imageDAO.deleteImage(id);
    }

    public List<Image> getImageList() {
        return imageDAO.listImage();
    }

    public Image getImage(Integer id) {
        return imageDAO.findImageById(id);
    }
    
}
