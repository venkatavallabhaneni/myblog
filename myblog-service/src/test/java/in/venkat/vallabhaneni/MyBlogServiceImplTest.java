package in.venkat.vallabhaneni;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import in.venkat.vallabhaneni.domain.MyBlog;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyBlogServiceImplTest {

	@Mock
	private MyBlogDao daoMock;

	@InjectMocks
	private MyBlogServiceImpl serviceMock;

	MyBlog aMyBlog = null;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		aMyBlog = mock(MyBlog.class);
		aMyBlog.setContent("Bannana");
		aMyBlog.setId(101L);
	}

	@Test
	public void shouldReturnProductsList_whenFindAllIsCalled() {

		List<MyBlog> list = new ArrayList<MyBlog>();
		list.add(aMyBlog);

		when(daoMock.findAll()).thenReturn(list);

		assertArrayEquals(serviceMock.findAll().toArray(), list.toArray());
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullpointerException_whenFindAllIsCalled_andServiceIsNull() {

		when(daoMock.findAll()).thenThrow(NullPointerException.class);
		serviceMock.findAll();
	}

	@Test
	public void shouldReturnProduct_101_whenFindByIdIsCalled() {

		when(daoMock.findById(101L)).thenReturn(Optional.of(aMyBlog));
		assertEquals(serviceMock.findById(101L), Optional.of(aMyBlog));
	}

	@Test
	public void shouldReturnProduct_Null_whenFindByIdIsCalled_with102() {

		when(daoMock.findById(102L)).thenReturn(Optional.empty());
		assertEquals(serviceMock.findById(102L), Optional.empty());
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowException_whenSaveIsCalledWithNullArgument() {

		when(daoMock.save(null)).thenThrow(IllegalArgumentException.class);
		serviceMock.persist(null);
	}

	@Test
	@Ignore
	public void shouldReturnProduct_whenSaveIsCalled() {

		when(daoMock.save(any(MyBlog.class))).thenAnswer(new Answer<MyBlog>() {
			@Override
			public MyBlog answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();

				System.out.println(arguments);
				if (arguments != null && arguments.length > 0 && arguments[0] != null) {
					MyBlog aProduct = (MyBlog) arguments[0];
					aProduct.setId(102L);
					aProduct.setContent("Lemon");
					return aProduct;
				}
				return null;
			}
		});

		assertEquals(serviceMock.persist(aMyBlog).getContent(), "Lemon");

	}

}
