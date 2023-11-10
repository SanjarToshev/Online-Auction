package uz.pdp.onlineauctiondemo.payload;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String phoneNumber;
    @NotNull
    @NotBlank
    private String password;

}
