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
    private Long articleId;
    private int article_writerId;
    private String articleTitle;
    private String articleExtract;
    private String articleText;
    private int articlePublic;
    @TableField(fill = FieldFill.INSERT)
    private Date dateCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date dateModify;
}
