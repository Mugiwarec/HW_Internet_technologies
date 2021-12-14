package com.mugiwarec.app.employee;

import com.mugiwarec.app.mapper.EmployeeMapper;
import com.mugiwarec.app.model.Employee;
import com.mugiwarec.app.service.EmployeeService;
import com.mugiwarec.app.service.impl.EmployeeServiceImpl;
import com.mugiwarec.core.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    Employee slava = null;

    {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        try {
            slava = new Employee(
                    1L, "Slava", "Popov",
                    format.parse("24-06-1998"), 1, "Java Developer",
                    "Moscow", format.parse("01-07-2021"), null
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private EmployeeService service;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Mockito.when(employeeRepository.findById(slava.getId()))
                .thenReturn(Optional.of(EmployeeMapper.MAPPER.toEmployeeEntity(slava)));
    }

    @Test
    public void whenValidId_thenEmployeeShouldBeFound() {
        Long id = 1L;
        Optional<Employee> found = service.findEmployeeById(id);

        found.ifPresent(employee -> assertThat(employee).isEqualTo(slava));
    }
}
