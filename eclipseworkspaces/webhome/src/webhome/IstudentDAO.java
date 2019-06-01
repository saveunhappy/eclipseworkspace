package webhome;

import java.util.List;

public interface IstudentDAO {
	void save(Student stu);
	void delete(Long id);
	void update(Long id,Student stu);
	Student get(Long id);
	List<Student> list();
}
