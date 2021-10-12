package pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;

@Data
public class Article {
    @TableId(type = IdType.AUTO)
    private int article_id;
    private int article_writer_id;
    private String article_title;
    private String article_extract;
    private String article_text;
    private int article_public;
    @TableField(fill = FieldFill.INSERT)
    private Date date_create;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date date_modify;
}
