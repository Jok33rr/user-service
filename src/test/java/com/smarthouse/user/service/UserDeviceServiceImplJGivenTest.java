package com.smarthouse.user.service;


import com.smarthouse.commonutil.entities.Device;
import com.smarthouse.commonutil.entities.UserDevice;
import com.smarthouse.commonutil.entities.UserDeviceId;
import com.smarthouse.user.repository.UserDeviceRepository;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.junit.SimpleScenarioTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class UserDeviceServiceImplJGivenTest extends SimpleScenarioTest<UserDeviceServiceImplJGivenTest.TestSteps> {

    private static UserDeviceRepository deviceRepository = Mockito.mock(UserDeviceRepository.class);

    @InjectMocks
    private static UserDeviceServiceImpl service = new UserDeviceServiceImpl(deviceRepository);

    @BeforeScenario
    public void init() {
        MockitoAnnotations.initMocks(this);
        // after initMocks() you can use the standard mockito functionality to mock methods and instances.
    }

    @Test
    public void find_all_test() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }

    @Test
    public void find_by_id_test() {
        given().some_state();
        when().some_action1();
        then().some_outcome1();
    }

    @Test
    public void delete_by_user_device_id_test() {
        given().some_state();
        when().some_action2();
        then().some_outcome2();
    }

    @Test
    public void delete_by_user_device_test() {
        given().some_state();
        when().some_action3();
        then().some_outcome3();
    }

    @Test
    public void save_user_device_test() {
        given().some_state();
        when().some_action4();
        then().some_outcome4();
    }

    public static class TestSteps extends Stage<TestSteps> {


        List<UserDevice> userDevices;

        List<UserDevice> op1;

        UserDevice userDevice;

        UserDevice userDevice1;

        UserDeviceId userDeviceId;

        UserDevice op;

        public TestSteps some_state() {
            Device device = new Device();
            userDevice = new UserDevice();
            userDeviceId = new UserDeviceId();
            userDeviceId.setDeviceId((long) 1);
            userDeviceId.setUserId((long) 1);
            device.setId((long) 1);
            device.setName("Test");

            return self();
        }


        public TestSteps some_action() {
            userDevices = new ArrayList<>();
            userDevices.add(userDevice);
            op1 = new ArrayList<>();
            Mockito.when(deviceRepository.findAll()).thenReturn(userDevices);
            op1 = service.getAll();
            return self();
        }

        public TestSteps some_action1() {
            Mockito.when(deviceRepository.findOne(userDeviceId)).thenReturn(userDevice);
            Optional<UserDevice> optionalUser = service.getById(userDeviceId);
            userDevice1 = optionalUser.isPresent() ? optionalUser.get() : new UserDevice();
            return self();
        }

        public TestSteps some_action2() {
            service.deleteById(userDeviceId);
            return self();
        }

        public TestSteps some_action3() {
            service.delete(userDevice);
            return self();
        }

        public TestSteps some_action4() {
            Mockito.when(deviceRepository.saveAndFlush(userDevice)).thenReturn(userDevice);
            op = service.save(userDevice);
            return self();
        }


        public void some_outcome() {
            Assert.assertEquals(op1, userDevices);
        }

        public void some_outcome1() {
            Assert.assertEquals(userDevice, userDevice1);
        }

        public void some_outcome2() {
            Mockito.verify(deviceRepository, times(1)).delete(userDeviceId);
        }

        public void some_outcome3() {
            Mockito.verify(deviceRepository, times(1)).delete(userDevice);
        }

        public void some_outcome4() {
            Assert.assertEquals(op, userDevice);
        }

    }
}
