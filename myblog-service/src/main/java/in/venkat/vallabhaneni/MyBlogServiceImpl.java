package in.venkat.vallabhaneni;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.venkat.vallabhaneni.domain.MyBlog;

@Service
public class MyBlogServiceImpl implements MyBlogService {

	@Autowired
	private MyBlogDao myBlogDao;

	@Override
	public List<MyBlog> findAll() {
		return (List<MyBlog>) myBlogDao.findAll();

	}

	@Override
	public Optional<MyBlog> findById(Long id) {
		return myBlogDao.findById(id);

	}

	@Override
	public MyBlog persist(MyBlog aMyBlog) {
		if (aMyBlog == null) {
			throw new IllegalArgumentException();
		}
		return myBlogDao.save(aMyBlog);
	}

	@Override
	public void delete(MyBlog aMyBlog) {
		myBlogDao.delete(aMyBlog);
	}

	@Override
	public Optional<MyBlog> findByCategory(String name) {
		return myBlogDao.findByCategory(name);
	}

	@Override
	public List<MyBlog> persistMany(List<MyBlog> t) {
		return (List<MyBlog>) myBlogDao.saveAll(t);
	}

}
