package com.smarthouse.user.service

import com.smarthouse.commonutil.entities.Device
import com.smarthouse.commonutil.entities.UserDevice
import com.smarthouse.commonutil.entities.UserDeviceId
import com.smarthouse.user.repository.UserDeviceRepository



class UserDeviceServiceImplTestSpock extends spock.lang.Specification {

    def deviceRepository = Mock(UserDeviceRepository)

    def  service = UserDeviceServiceImpl


    def"get all devices"(){
        given:
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        List<UserDevice> userDevices = new ArrayList<UserDevice>();
        userDevices.add(userDevice);
        when:
        List<UserDevice> op1 =  service.getAll();
        then:
        1*deviceRepository.findAll()
    }
    def "test Find By ID"(){
    given:
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        when:
        Optional<UserDevice> optionalUser = service.getById(userDeviceId);
        UserDevice userDevice1 = optionalUser.isPresent() ? optionalUser.get() : new UserDevice();
        then:
        1*deviceRepository.findOne(userDeviceId)

    }
    def "test Delete By Id"(){
        given:
        service = new UserDeviceServiceImpl(deviceRepository)
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        when:
        service.deleteById(userDeviceId)
        then:
        1* deviceRepository.delete(userDeviceId)

    }

    def "test Save"(){
    given:
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        when:
        UserDevice op = service.save(userDevice);
        then:
        1* deviceRepository.saveAndFlush(userDevice)

    }

    def "test Delete Device"(){
        given:
        service = new UserDeviceServiceImpl(deviceRepository);
        Device device = new Device();
        UserDevice userDevice = new UserDevice();
        UserDeviceId userDeviceId = new UserDeviceId();
        userDeviceId.setDeviceId((long)1);
        userDeviceId.setUserId((long)1);
        device.setId((long)1);
        device.setName("Test");
        when:
        service.delete(userDevice);
        then:
        1 * deviceRepository.delete(userDevice);

    }
}
