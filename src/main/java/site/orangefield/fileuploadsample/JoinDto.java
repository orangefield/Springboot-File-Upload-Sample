package site.orangefield.fileuploadsample;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinDto {
    private String username; // form태그 : name="username"
    private MultipartFile file; // form태그 : name="file"

    // Dto로 받은 정보들을 합쳐서 영속화된 Entity인 User 오브젝트를 만든다
    public User toEntity(String imgurl) {
        User user = new User();
        user.setUsername(username);
        user.setImgurl(imgurl);
        return user;
    }
}
