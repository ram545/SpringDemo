package ServiceTest;

import com.example.model.Course;
import com.example.repository.CourseRepo;
import com.example.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    private CourseRepo mockRepoHandle;

    @InjectMocks
    private CourseService mockCourseService;

    @Test
    public void getCourseListbasicTest(){
        List<Course> data = Arrays.asList(new Course(1,"CSE","Harris"),
                new Course(2, "ECE","Danes"),
                new Course(3, "Chem", "Drive"));
        when(mockRepoHandle.findAll()).thenReturn(data);
        assertEquals(data,mockCourseService.getCourseList());
    }

    @Test
    public void getCourseListnullEmptyListTest(){
        List<Course> data = new ArrayList<Course>();
        when(mockRepoHandle.findAll()).thenReturn(data);
        assertEquals(data,mockCourseService.getCourseList());
    }

     @Test
    public void getCoursebyIdBasicTest() throws NullPointerException, NoSuchElementException {
        Course record = new Course(1, "Bre", "Dreg");
        when(mockRepoHandle.findById(Mockito.anyLong())).thenReturn(Optional.of(record));
        when(mockRepoHandle.existsById(Mockito.anyLong())).thenReturn(true);
        int iter = -1;
        while( iter++ < 1000000)
            assertEquals(record,mockCourseService.getCoursebyId(iter));
    }

    @Test
    public void getCoursebyIdNullTest(){
        when(mockRepoHandle.existsById(2L)).thenReturn(false);
        assertNull(mockCourseService.getCoursebyId(2));
    }

    @Test
    public void getCoursebyIdNullButExistsTest() throws NoSuchElementException{
        when(mockRepoHandle.existsById(2L)).thenReturn(true);
        when(mockRepoHandle.findById(2L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> {mockCourseService.getCoursebyId(2L);});
    }

    @Test
    public void addNewCourseBasicTest(){
       Course record = new Course(3, "Bre", "Dreg");
        when(mockRepoHandle.save(record)).thenReturn(record);
        assertEquals(3, mockCourseService.addNewCourse(record));
    }




}
