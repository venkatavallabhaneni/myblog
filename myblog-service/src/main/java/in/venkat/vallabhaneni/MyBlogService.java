package in.venkat.vallabhaneni;

import java.util.Optional;

import in.venkat.vallabhaneni.domain.MyBlog;

public interface MyBlogService extends BaseService<MyBlog, Long> {

	public Optional<MyBlog> findByCategory(String name);

}
