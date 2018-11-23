package in.venkat.vallabhaneni;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import in.venkat.vallabhaneni.domain.MyBlog;

public interface MyBlogDao extends CrudRepository<MyBlog, Number>{
	
	public Optional<MyBlog> findByCategory(String category);
	
}
