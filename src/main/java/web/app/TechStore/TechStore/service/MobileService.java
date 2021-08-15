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
                product.getBrand(), product.getSeries(), product.getBuild(),product.getAvailableQuantity(),
                product.getReservedQuantity(), product.getPrice(), product.getImageName(), display.getScreenSize(),
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
                        " and (:priceTo >= p.price and :priceFrom <= p.price)" +
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
        query.setParameter("priceFrom", request.getPriceFrom());
        query.setParameter("priceTo", request.getPriceTo());

        List<Products> resultList = (List<Products>) query.getResultList();

        ArrayList<FilteredMobileListResponse.ProductDto> productDtos = new ArrayList<>();

        resultList.forEach(products -> {
            productDtos.add(new FilteredMobileListResponse.ProductDto(products.getProductId(), products.getName(),
                    products.getPrice(), products.getImageName()));
        });

        return new FilteredMobileListResponse(productDtos);
    }

    public AddProductResponse addProduct(AddProductRequest request){
        Display display = new Display(request.getScreenSize(), request.getScreenResolution(), request.getPpi(),
                request.getScreenPanelType(), request.getNumberOfColors(), request.getScreenFormat(),
                request.getTrueTone(), request.getBrightness(), request.getScreenProtection(),
                request.getDolbyVision());
        entityManager.getTransaction().begin();
        entityManager.persist(display);
        entityManager.getTransaction().commit();

        Sensors sensor = new Sensors(request.getFingerprint(), request.getAcceleremeter(), request.getCompass(),
                request.getGyroscope(), request.getProximity());
        entityManager.getTransaction().begin();
        entityManager.persist(sensor);
        entityManager.getTransaction().commit();

        Camera camera = new Camera(request.getNumberOfCamera(), request.getMainCameraMp(), request.getSecondCameraMp(),
                request.getThirdCameraMp(), request.getForthCameraMp(), request.getVideoResolution(),
                request.getAutofocus(), request.getLighting(), request.getAperture(), request.getHdr(),
                request.getPanorama(), request.getSelfieCamera(), request.getSelfieVideoResolution(),
                request.getSelfieAutofocus(), request.getSelfieHdr());
        entityManager.getTransaction().begin();
        entityManager.persist(camera);
        entityManager.getTransaction().commit();

        AdditionalSpecs additionalSpecs = new AdditionalSpecs(request.getFmRatioSupport(),
                request.getNumberOfSpeakers(), request.getLoudspeaker(), request.getMicrophone(), request.getUsbTypeC(),
                request.getLightningCorrect(), request.getAudioJack(), request.getBluetooth(), request.getNfc(),
                request.getWifiDirect(), request.getAnt(), request.getFastCharging(), request.getWirelessCharging(),
                request.getBatteryDescription(), request.getMusicPlaybackTime(), request.getTypeOfBattery(),
                request.getWaterResistant(), request.getWaterResistantDepth(), request.getOperatingSystem(),
                request.getOperatingSystemVersion(), request.getUpgradable(), request.getColor(), request.getDimensions(),
                request.getWeight(), request.getAdapter(), request.getCableIncluded(), request.getHeadphones(),
                request.getWarranty());
        entityManager.getTransaction().begin();
        entityManager.persist(additionalSpecs);
        entityManager.getTransaction().commit();

        GeneralInfo generalInfo = new GeneralInfo(request.getTwoG(), request.getThreeG(), request.getLte(),
                request.getLteA(), request.getFiveG(), request.getDualSim(), request.getDualStandby(),
                request.getSimType());
        entityManager.getTransaction().begin();
        entityManager.persist(generalInfo);
        entityManager.getTransaction().commit();

        Gps gps = new Gps(request.getaGps(), request.getGalileo(), request.getBds(), request.getGlonass());
        entityManager.getTransaction().begin();
        entityManager.persist(gps);
        entityManager.getTransaction().commit();

        Processor processor = new Processor(request.getManufacturer(), request.getTypeOfProcessor(),
                request.getModelOfProcessor(), request.getNumberOfCores(), request.getGraphicProcessor(),
                request.getLithography());
        entityManager.getTransaction().begin();
        entityManager.persist(processor);
        entityManager.getTransaction().commit();

        Memory memory = new Memory(request.getRam(), request.getInternalMemory(), request.getMemoryCardSupport(),
                request.getMemoryCardMaximumSize(), request.getTypeOfMemoryCard());
        entityManager.getTransaction().begin();
        entityManager.persist(memory);
        entityManager.getTransaction().commit();

        Products product = new Products(request.getName(), request.getModelName(), request.getBrand(),
                request.getSeries(), request.getBuild(), request.getAvailableQuantity(), request.getReservedQuantity(),
                request.getPrice(), request.getImageName(), generalInfo, display,
                camera, processor, memory, sensor, gps, additionalSpecs);

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        return new AddProductResponse(true, product.getProductId());
    }

    public EditProductResponse editProduct(EditProductRequest request){
        long prod_id = request.getProductId();
        Products product = entityManager.find(Products.class, prod_id);
        Display display = product.getDisplayByDisplayId();
        GeneralInfo genInfo = product.getGeneralInfoByGeneralId();
        Gps gps = product.getGpsByGpsId();
        Camera cam = product.getCameraByCameraId();
        Processor proc = product.getProcessorByProcessorId();
        Sensors sens = product.getSensorsBySensorsId();
        Memory mem = product.getMemoryByMemoryId();
        AdditionalSpecs addSpc = product.getAdditionalSpecsBySpecsId();

        entityManager.getTransaction().begin();

        product.setBrand(request.getBrand());
        product.setBuild(request.getBuild());
        product.setName(request.getName());
        product.setModelName(request.getModelName());
        product.setSeries(request.getSeries());
        product.setAvailableQuantity(request.getAvailableQuantity());
        product.setPrice(request.getPrice());
        product.setImageName(request.getImageName());
        product.setReservedQuantity(request.getReservedQuantity());

        display.setDolbyVision(request.getDolbyVision());
        display.setBrightness(request.getBrightness());
        display.setPpi(request.getPpi());
        display.setScreenFormat(request.getScreenFormat());
        display.setScreenPanelType(request.getScreenPanelType());
        display.setNumberOfColors(request.getNumberOfColors());
        display.setScreenSize(request.getScreenSize());
        display.setScreenProtection(request.getScreenProtection());
        display.setTrueTone(request.getTrueTone());
        display.setScreenResolution(request.getScreenResolution());

        genInfo.setDualSim(request.getDualSim());
        genInfo.setDualStandby(request.getDualStandby());
        genInfo.setFiveG(request.getFiveG());
        genInfo.setLte(request.getLte());
        genInfo.setLteA(request.getLteA());
        genInfo.setSimType(request.getSimType());
        genInfo.setThreeG(request.getThreeG());
        genInfo.setTwoG(request.getTwoG());

        gps.setaGps(request.getaGps());
        gps.setBds(request.getBds());
        gps.setGalileo(request.getGalileo());
        gps.setGlonass(request.getGlonass());

        cam.setAperture(request.getAperture());
        cam.setAutofocus(request.getAutofocus());
        cam.setForthCameraMp(request.getForthCameraMp());
        cam.setHdr(request.getHdr());
        cam.setLighting(request.getLighting());
        cam.setMainCameraMp(request.getMainCameraMp());
        cam.setNumberOfCamera(request.getNumberOfCamera());
        cam.setPanorama(request.getPanorama());
        cam.setSecondCameraMp(request.getSecondCameraMp());
        cam.setSelfieAutofocus(request.getSelfieAutofocus());
        cam.setSelfieCamera(request.getSelfieCamera());
        cam.setSelfieHdr(request.getSelfieHdr());
        cam.setSelfieVideoResolution(request.getSelfieVideoResolution());
        cam.setThirdCameraMp(request.getThirdCameraMp());
        cam.setVideoResolution(request.getVideoResolution());

        proc.setGraphicProcessor(request.getGraphicProcessor());
        proc.setLithography(request.getLithography());
        proc.setManufacturer(request.getManufacturer());
        proc.setModelOfProcessor(request.getModelOfProcessor());
        proc.setNumberOfCores(request.getNumberOfCores());
        proc.setTypeOfProcessor(request.getTypeOfProcessor());

        sens.setAcceleremeter(request.getAcceleremeter());
        sens.setCompass(request.getCompass());
        sens.setFingerprint(request.getFingerprint());
        sens.setGyroscope(request.getGyroscope());
        sens.setProximity(request.getProximity());

        mem.setInternalMemory(request.getInternalMemory());
        mem.setMemoryCardMaximumSize(request.getMemoryCardMaximumSize());
        mem.setMemoryCardSupport(request.getMemoryCardSupport());
        mem.setRam(request.getRam());
        mem.setTypeOfMemoryCard(request.getTypeOfMemoryCard());

        addSpc.setAdapter(request.getAdapter());
        addSpc.setAnt(request.getAnt());
        addSpc.setAudioJack(request.getAudioJack());
        addSpc.setBluetooth(request.getBluetooth());
        addSpc.setColor(request.getColor());
        addSpc.setBatteryDescription(request.getBatteryDescription());
        addSpc.setCableIncluded(request.getCableIncluded());
        addSpc.setDimensions(request.getDimensions());
        addSpc.setFastCharging(request.getFastCharging());
        addSpc.setFmRatioSupport(request.getFmRatioSupport());
        addSpc.setHeadphones(request.getHeadphones());
        addSpc.setLightningCorrect(request.getLightningCorrect());
        addSpc.setLoudspeaker(request.getLoudspeaker());
        addSpc.setMicrophone(request.getMicrophone());
        addSpc.setMusicPlaybackTime(request.getAdapter());
        addSpc.setNfc(request.getNfc());
        addSpc.setNumberOfSpeakers(request.getNumberOfSpeakers());
        addSpc.setOperatingSystem(request.getOperatingSystem());
        addSpc.setOperatingSystemVersion(request.getOperatingSystemVersion());
        addSpc.setTypeOfBattery(request.getTypeOfBattery());
        addSpc.setUpgradable(request.getUpgradable());
        addSpc.setUsbTypeC(request.getUsbTypeC());
        addSpc.setWarranty(request.getWarranty());
        addSpc.setWaterResistant(request.getWaterResistant());
        addSpc.setWaterResistantDepth(request.getWaterResistantDepth());
        addSpc.setWeight(request.getWeight());
        addSpc.setWifiDirect(request.getWifiDirect());
        addSpc.setWirelessCharging(request.getWirelessCharging());

        entityManager.getTransaction().commit();

        return new EditProductResponse(true);
    }

    public DeleteProductResponse deleteProduct(DeleteProductRequest request){
        long prod_id = request.getProductId();
        Products product = entityManager.find(Products.class, prod_id);
        Display display = product.getDisplayByDisplayId();
        GeneralInfo genInfo = product.getGeneralInfoByGeneralId();
        Gps gps = product.getGpsByGpsId();
        Camera cam = product.getCameraByCameraId();
        Processor proc = product.getProcessorByProcessorId();
        Sensors sens = product.getSensorsBySensorsId();
        Memory mem = product.getMemoryByMemoryId();
        AdditionalSpecs addSpc = product.getAdditionalSpecsBySpecsId();

        entityManager.getTransaction().begin();
        entityManager.remove(display);
        entityManager.remove(genInfo);
        entityManager.remove(gps);
        entityManager.remove(cam);
        entityManager.remove(proc);
        entityManager.remove(sens);
        entityManager.remove(mem);
        entityManager.remove(addSpc);
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        return new DeleteProductResponse(true);
    }
}
