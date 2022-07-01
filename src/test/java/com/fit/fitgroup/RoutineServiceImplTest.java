package com.fit.fitgroup;

import com.fit.fitgroup.routines.domain.model.Routine;
import com.fit.fitgroup.routines.domain.repository.ExerciseRepository;
import com.fit.fitgroup.routines.domain.repository.RoutineRepository;
import com.fit.fitgroup.routines.domain.service.RoutineService;
import com.fit.fitgroup.shared.exception.exception.ResourceNotFoundException;
import com.fit.fitgroup.routines.service.RoutineServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class RoutineServiceImplTest {
    @MockBean
    private RoutineRepository routineRepository;
    @MockBean
    private ExerciseRepository exerciseRepository;
    @Autowired
    private RoutineService routineService;

    @TestConfiguration
    static class RoutineServiceImplTestConfiguration {
        @Bean
        public RoutineService routineService() {
            return new RoutineServiceImpl();
        }
    }

    @Test
    @DisplayName("When getRoutineByName With Valid Name Then Returns Routine")
    public void whenGetRoutineByNameWithValidNameThenReturnsRoutine() {
        //Arrange
        String name = "Abs Routine";
        Integer rating = 2;
        Routine routine = new Routine();
        routine.setId(1L);
        routine.setName(name);
        routine.setRating(rating);
        when(routineRepository.findByName(name)).
                thenReturn(Optional.of(routine));

        //Act
        Routine foundRoutine = routineService.getRoutineByName(name);

        //Assert
        assertThat(foundRoutine.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("When getRoutineByName With Invalid Name Then Returns ResourceNotFoundException")
    public void whenGetRoutineByNameWithInvalidNameThenReturnsResourceNotFoundException() {
        //Arrange
        String name = "Abs Routine";
        String template = "Resource %s not found for %s with value %s";
        when(routineRepository.findByName(name)).
                thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Routine", "Name",name);

        //Act
        Throwable exception = catchThrowable(()->{
            Routine foundRoutine = routineService.getRoutineByName(name);
        });

        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
