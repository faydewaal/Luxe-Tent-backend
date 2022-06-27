package nl.novi.luxetent.services;
import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.repositories.FileUploadRepository;
import nl.novi.luxetent.repositories.TentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TentService {

    private final TentRepository tentRepository;
    private final FileUploadRepository uploadRepository;

    @Autowired
    public TentService(TentRepository tentRepository, FileUploadRepository uploadRepository) {
        this.tentRepository = tentRepository;
        this.uploadRepository = uploadRepository;
    }

    public List<Tent> getAllTents() {
        return tentRepository.findAll();
    }

    public Tent getTent(Long tentId) {

        Optional<Tent> tent = tentRepository.findById(tentId);

        if (tent.isPresent()) {

            return tent.get();

        } else {

            throw new RecordNotFoundException("Deze tent bestaat niet");

        }
    }


    public Tent saveTent(Tent tent) {
        return tentRepository.save(tent);
    }

    public void deleteTent(Long tentId) {
        tentRepository.deleteById(tentId);
    }

    public void assignPhotoToTent(String fileName, Long tentId) {
        Optional<Tent> optionalTent = tentRepository.findById(tentId);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(fileName);

        if(optionalTent.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse photo = fileUploadResponse.get();
            Tent tent = optionalTent.get();

            tent.setFile(photo);
            tentRepository.save(tent);
        }
    }

}





