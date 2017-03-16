package easytests.mappers;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vkpankov
 */
public class MappersTestsTest {

    private void TestMapperTests(Class mapperClass, Class mapperTestClass) {

        Method[] methodsInMapper = mapperClass.getDeclaredMethods();
        Method[] methodsInMapperTest = mapperTestClass.getDeclaredMethods();

        List<String> usersMapperTestsNames = new ArrayList<>();

        for(Method method : methodsInMapperTest) {

            usersMapperTestsNames.add(method.getName());

        }

        for(Method method : methodsInMapper) {

            String testName = "test" + method.getName().substring(0, 1).toUpperCase() + method.getName().substring(1);

            if(!usersMapperTestsNames.contains((String)testName)) {

                Assert.fail();
                return;

            }

        }

    }

    @Test
    public void TestUsersMapperTests() {

        TestMapperTests(UsersMapper.class, UsersMapperTest.class);
    }

    @Test
    public void TestSubjectsMapperTests() {

        TestMapperTests(SubjectsMapper.class, SubjectsMapperTest.class);

    }
}
