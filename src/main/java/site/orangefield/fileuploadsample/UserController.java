package site.orangefield.fileuploadsample;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/main")
    public String main(Model model) {
        User user = userRepository.findById(1).get();

        model.addAttribute("user", user);

        return "main";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(JoinDto joinDto) {

        UUID uuid = UUID.randomUUID();

        String requestFileName = joinDto.getFile().getOriginalFilename();
        String imgurl = uuid + "_" + requestFileName;

        try {
            // .jar (X)
            // Path filePath = Paths.get("C:/upload/" + imgurl);
            Path filePath = Paths.get("src/main/resources/static/upload" + imgurl);
            Files.write(filePath, joinDto.getFile().getBytes());

            userRepository.save(joinDto.toEntity(imgurl));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "joinComplete";
    }
}
