package in.venkat.vallabhaneni.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name = "MYBLOG")
@Table(name="MYBLOG")
public class MyBlog {

	@Id
	@SequenceGenerator(name = "myblogSeqGen", sequenceName = "seq_id_myblog", initialValue = 5, allocationSize = 100)
	@GeneratedValue(generator = "myblogSeqGen")
	private Long id;

	@Lob
	private String content;

	@NotNull
	private String category;

}
