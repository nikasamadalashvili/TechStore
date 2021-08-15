package web.app.TechStore.TechStore.service;



import web.app.TechStore.TechStore.DomainModels.*;
import web.app.TechStore.TechStore.service.models.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MobileService {
    private EntityManager entityManager;

    public MobileService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*Does not work if provided product doesn't have a foreign key in every table */
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
        //:brandsEmpty is not null or
        Query query = entityManager.createQuery
                ("select p from Products p" +
                        " where ((:name is null or p.name like concat('%', :name, '%'))" +
                        " and (:brandsEmpty = true or p.brand in :brands)" +
                        " and (:operatingSystemsEmpty = true or p.additionalSpecsBySpecsId.operatingSystem in :operatingSystems)" +
                        " and (:screenSizeEmpty = true or p.displayByDisplayId.screenSize in :screenSizes)" +
                        " and (:screenResolutionsEmpty = true or p.displayByDisplayId.screenResolution in :screenResolutions)" +
                        " and (:ramsEmpty = true or p.memoryByMemoryId.ram in :rams)" +
                        " and (:internalMemoriesEmpty = true or p.memoryByMemoryId.internalMemory in :internalMemories)" +
                        " and (:memoryCardSupportsEmpty = true or p.memoryByMemoryId.memoryCardSupport in :memoryCardSupports)" +
                        " and (:numberOfCamerasEmpty = true or p.cameraByCameraId.numberOfCamera in :numberOfCameras)" +
                        " and (:mainCamMpsEmpty = true or p.cameraByCameraId.mainCameraMp in :mainCamMps)" +
                        " and (:secondCamMpsEmpty = true or p.cameraByCameraId.secondCameraMp in :secondCamMps)" +
                        " and (:typeOfProcessorsEmpty = true or p.processorByProcessorId.typeOfProcessor in :typeOfProcessors)" +
                        " and (:numberOfCoressEmpty = true or p.processorByProcessorId.numberOfCores in :numberOfCoress)" +
                        " and (:waterResistancesEmpty = true or p.additionalSpecsBySpecsId.waterResistant in :waterResistances)" +
                        " and (:dualSimsEmpty = true or p.generalInfoByGeneralId.dualSim in :dualSims)" +
                        " and (:ltesEmpty = true or p.generalInfoByGeneralId.lte in :ltes)" +
                        " and (:lteasEmpty = true or p.generalInfoByGeneralId.lteA in :lteas)" +
                        " and (:fiveGsEmpty = true or p.generalInfoByGeneralId.fiveG in :fiveGs)" +
                        " and (:nfssEmpty = true or p.additionalSpecsBySpecsId.nfc in :nfss)" +
                        " and (:colorsEmpty = true or p.additionalSpecsBySpecsId.color in :colors))");
        query.setParameter("name", request.getSearchBarText());
        query.setParameter("brands", request.getBrand());
        query.setParameter("brandsEmpty", request.getBrand().size() == 0);
        query.setParameter("operatingSystems", request.getOperatingSystem());
        query.setParameter("operatingSystemsEmpty", request.getOperatingSystem().size() == 0);
        query.setParameter("screenSizes", request.getScreenSize());
        query.setParameter("screenSizeEmpty", request.getScreenSize().size() == 0);
        query.setParameter("screenResolutions", request.getScreenResolution());
        query.setParameter("screenResolutionsEmpty", request.getScreenResolution().size() == 0);
        query.setParameter("rams", request.getRam());
        query.setParameter("ramsEmpty", request.getRam().size() == 0);
        query.setParameter("internalMemories", request.getInternalMemory());
        query.setParameter("internalMemoriesEmpty", request.getInternalMemory().size() == 0);
        query.setParameter("memoryCardSupports", request.getMemoryCardSupport());
        query.setParameter("memoryCardSupportsEmpty", request.getMemoryCardSupport().size() == 0);
        query.setParameter("numberOfCameras", request.getNumberOfCamera());
        query.setParameter("numberOfCamerasEmpty", request.getNumberOfCamera().size() == 0);
        query.setParameter("mainCamMps", request.getMainCameraMp());
        query.setParameter("mainCamMpsEmpty", request.getMainCameraMp().size() == 0);
        query.setParameter("secondCamMps", request.getSecondCameraMp());
        query.setParameter("secondCamMpsEmpty", request.getSecondCameraMp().size() == 0);
        query.setParameter("typeOfProcessors", request.getTypeOfProcessor());
        query.setParameter("typeOfProcessorsEmpty", request.getTypeOfProcessor().size() == 0);
        query.setParameter("numberOfCoress", request.getNumberOfCores());
        query.setParameter("numberOfCoressEmpty", request.getNumberOfCores().size() == 0);
        query.setParameter("waterResistances", request.getWaterResistant());
        query.setParameter("waterResistancesEmpty", request.getWaterResistant().size() == 0);
        query.setParameter("dualSims", request.getDualSim());
        query.setParameter("dualSimsEmpty", request.getDualSim().size() == 0);
        query.setParameter("ltes", request.getLte());
        query.setParameter("ltesEmpty", request.getLte().size() == 0);
        query.setParameter("lteas", request.getLteA());
        query.setParameter("lteasEmpty", request.getLteA().size() == 0);
        query.setParameter("fiveGs", request.getFiveG());
        query.setParameter("fiveGsEmpty", request.getFiveG().size() == 0);
        query.setParameter("nfss", request.getNfc());
        query.setParameter("nfssEmpty", request.getNfc().size() == 0);
        query.setParameter("colors", request.getColor());
        query.setParameter("colorsEmpty", request.getColor().size() == 0);

        List<Products> resultList = (List<Products>) query.getResultList();

        ArrayList<FilteredMobileListResponse.ProductDto> productDtos = new ArrayList<>();

        resultList.forEach(products -> {
            productDtos.add(new FilteredMobileListResponse.ProductDto(products.getProductId(), products.getName()));
        });

        return new FilteredMobileListResponse(productDtos);
    }

    //public AddProductResponse AddProduct(AddProductRequest request){

    //}
}
