package in.venkat.vallabhaneni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.venkat.vallabhaneni.MyBlogService;
import in.venkat.vallabhaneni.domain.MyBlog;

@RestController
@RequestMapping(value = "/content")
public class MyBlogController {

	@Autowired
	private MyBlogService myBlogService;

	@GetMapping(value = "/{category}", headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public MyBlog getByCategory(@PathVariable(value = "category") String category) {
		Optional<MyBlog> aProduct = myBlogService.findByCategory(category);

		if (aProduct.isPresent()) {
			return aProduct.get();
		}
		return null;
	}

	@GetMapping(headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<MyBlog> getAll() {
		return myBlogService.findAll();
	}

	@PostMapping(headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<MyBlog> create(@RequestBody List<MyBlog> products) {
		return myBlogService.persistMany(products);
	}

	@PutMapping(headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<MyBlog> update(@RequestBody List<MyBlog> aProduct) {
		return myBlogService.persistMany(aProduct);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json", produces = "application/json")
	public void delete(@PathVariable(value = "id") Long id) {

		MyBlog product = new MyBlog();
		
		myBlogService.delete(product);

	}

}
