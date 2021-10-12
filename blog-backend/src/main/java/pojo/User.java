package pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private int user_id;
    private String user_phone;
    private String user_email;
    private String user_password;
    private String user_name;
    private int user_type;
    @TableField(fill = FieldFill.INSERT)
    private Date date_create;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date date_modify;
}
