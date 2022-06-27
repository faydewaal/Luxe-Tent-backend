package nl.novi.luxetent.repositories;
import nl.novi.luxetent.models.FileUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FileUploadRepository extends JpaRepository<FileUploadResponse, String> {
    Optional<FileUploadResponse> findByFileName(String fileName);

}
