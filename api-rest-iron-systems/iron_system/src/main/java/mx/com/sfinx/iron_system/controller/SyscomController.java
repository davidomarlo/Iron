package mx.com.sfinx.iron_system.controller;

import io.swagger.annotations.ApiOperation;
import mx.com.sfinx.iron_system.business.SyscomBrand;
import mx.com.sfinx.iron_system.business.SyscomProduct;
import mx.com.sfinx.iron_system.business.SyscomToken;
import mx.com.sfinx.iron_system.domain.request.RequestToken;
import mx.com.sfinx.iron_system.domain.response.ResponseBrand;
import mx.com.sfinx.iron_system.domain.response.ResponseProd;
import mx.com.sfinx.iron_system.domain.response.ResponseToken;
import mx.com.sfinx.iron_system.utils.ApiConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST endpoint for Syscom operations
 *
 * @author Rubén García Venzor
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = ApiConstants.REST_API_VERSION+ApiConstants.CONTEXT_SYSTEM)
@CrossOrigin
public class SyscomController {

    @Autowired
    SyscomToken syscomToken;

    @Autowired
    SyscomProduct syscomProduct;

    private static final Logger log = LoggerFactory.getLogger(SyscomController.class);

    /**
     *
     * @param request
     * @return ResponseEntity
     */
    @ApiOperation(value = "Valor del token", response = ResponseToken.class)
    @RequestMapping(value = ApiConstants.SYSCOM_OPE_GET_TOKEN, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity valorToken(@RequestBody RequestToken request) {

        ResponseToken response = syscomToken.getTokenSyscom();

        ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.valueOf(response.getStatus()));

        return responseEntity;
    }

    @ApiOperation(value = "Traer marcas", response = ResponseProd.class)
    @RequestMapping(value = ApiConstants.SYSCOM_OPE_GET_BRANDS, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity unprodcuto(@RequestBody RequestToken request) {

        ResponseProd response= syscomProduct.getProduct();
        //ResponseBrand response = syscomBrand.getBrandSinmarca();
        //ResponseBrand response1 = syscomBrand.getBrandTrescx();

        ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.valueOf(response.getStatus()));

        return responseEntity;
    }

    @ApiOperation(value = "Traer marcas", response = ResponseProd.class)
    @RequestMapping(value = ApiConstants.SYSCOM_OPE_GET_PROD, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity idprodcuto(@RequestBody RequestToken request) {

        ResponseProd response= syscomProduct.getProduct();
        //ResponseBrand response = syscomBrand.getBrandSinmarca();
        //ResponseBrand response1 = syscomBrand.getBrandTrescx();

        ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.valueOf(response.getStatus()));

        return responseEntity;
    }

}
