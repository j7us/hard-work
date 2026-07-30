package org.example;

/**
 * Сервис сохранения фотографий товара от пользователя, так как в системе могут быть битые товары, то нам необходимо
 * подтвердить сохранение изображений в сторонней системе s3 и сохранять в базу уже после подтверждения окончательного сохранения.
 */
@Component
@RequiredArgsConstructor
public class ImageUploadService {
    private final ImageClient imageClient;
    private final ImageRepository imageRepository;

    public void saveImage(Image image) {
        validateImage(image);
        ImageUpdated updated = imageClient.send(image);
        imageRepository.save(image);
    }

    private boolean validateImage(Image image) {
        ...
    }
}
