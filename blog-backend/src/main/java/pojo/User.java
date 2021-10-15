package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private String userName;
    private int userType;
    @TableField(fill = FieldFill.INSERT)
    private Date dateCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date dateModify;
}
