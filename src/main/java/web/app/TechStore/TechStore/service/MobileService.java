package web.app.TechStore.TechStore.service;



import web.app.TechStore.TechStore.DomainModels.*;
import web.app.TechStore.TechStore.service.models.FilteredMobileListRequest;
import web.app.TechStore.TechStore.service.models.FilteredMobileListResponse;
import web.app.TechStore.TechStore.service.models.MobileDetailsRequest;
import web.app.TechStore.TechStore.service.models.MobileDetailsResponse;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MobileService {
    private EntityManager entityManager;

    public MobileService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //doesnt return foreign keys
    public MobileDetailsResponse getMobileDetails(MobileDetailsRequest request) {
        Products product = entityManager.find(Products.class,request.getId());
        Display display = product.getDisplayByDisplayId();
        GeneralInfo genInfo = product.getGeneralInfoByGeneralId();
        Gps gps = product.getGpsByGpsId();
        Camera cam = product.getCameraByCameraId();
        Processor proc = product.getProcessorByProcessorId();
        Sensors sens = product.getSensorsBySensorsId();
        Memory mem = product.getMemoryByMemoryId();
        AdditionalSpecs addSpc = product.getAdditionalSpecsBySpecsId();
        return new MobileDetailsResponse(product.getProductId(),product.getName(),product.getModelName(),
                product.getBrand(), product.getSeries(), product.getBuild(), display.getScreenSize(),
                display.getScreenResolution(), display.getPpi(), display.getScreenPanelType(),
                display.getNumberOfColors(), display.getScreenFormat(), display.getTrueTone(),
                display.getBrightness(), display.getScreenProtection(), display.getDolbyVision(),
                addSpc.getFmRatioSupport(),addSpc.getNumberOfSpeakers(), addSpc.getLoudspeaker(), addSpc.getMicrophone(),
                addSpc.getUsbTypeC(), addSpc.getLightningCorrect(), addSpc.getAudioJack(), addSpc.getBluetooth(),
                addSpc.getNfc(), addSpc.getWifiDirect(), addSpc.getAnt(), addSpc.getFastCharging(),
                addSpc.getWirelessCharging(), addSpc.getBatteryDescription(), addSpc.getMusicPlaybackTime(),
                addSpc.getTypeOfBattery(), addSpc.getWaterResistant(), addSpc.getWaterResistantDepth(),
                addSpc.getOperatingSystem(), addSpc.getOperatingSystemVersion(), addSpc.getUpgradable(),
                addSpc.getColor(), addSpc.getDimensions(), addSpc.getWeight(), addSpc.getAdapter(),
                addSpc.getCableIncluded(), addSpc.getHeadphones(), addSpc.getWarranty(),genInfo.getTwoG(),
                genInfo.getThreeG(),genInfo.getLte(),genInfo.getLteA(),genInfo.getFiveG(),genInfo.getDualSim(),
                genInfo.getDualStandby(),genInfo.getSimType(),gps.getaGps(),gps.getGalileo(),gps.getBds(),gps.getGlonass(),
                mem.getRam(),mem.getInternalMemory(),mem.getMemoryCardSupport(),mem.getMemoryCardMaximumSize(),
                mem.getTypeOfMemoryCard(), proc.getManufacturer(),proc.getTypeOfProcessor(),proc.getModelOfProcessor(),
                proc.getNumberOfCores(),proc.getGraphicProcessor(),proc.getLithography(),cam.getNumberOfCamera(),
                cam.getMainCameraMp(),cam.getSecondCameraMp(),cam.getThirdCameraMp(),cam.getForthCameraMp(),
                cam.getVideoResolution(),cam.getAutofocus(),cam.getLighting(),cam.getAperture(),cam.getHdr(),
                cam.getPanorama(),cam.getSelfieCamera(),cam.getSelfieVideoResolution(),cam.getSelfieAutofocus(),
                cam.getSelfieHdr(),sens.getFingerprint(),sens.getAcceleremeter(),sens.getCompass(),sens.getGyroscope(),
                sens.getProximity());
    }


    public FilteredMobileListResponse getFilteredMobileList(FilteredMobileListRequest request) {
        Query query = entityManager.createQuery("select p from Products p where (:name is null or p.name = :name)");
        query.setParameter("name", request.getName());
        List<Products> resultList = (List<Products>) query.getResultList();

        ArrayList<FilteredMobileListResponse.ProductDto> productDtos = new ArrayList<>();

        resultList.forEach(products -> {
            productDtos.add(new FilteredMobileListResponse.ProductDto(products.getProductId(), products.getName()));
        });

        return new FilteredMobileListResponse(productDtos);
    }
}
