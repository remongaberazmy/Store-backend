package com.remon.store.service.mapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MapperService {

	@Autowired
	private DozerBeanMapper mapper;
	
	@Autowired
	private ApplicationContext context;
	
	@Value(value = "classpath://dozer-mapping/*.xml") 
	private Resource[] resources;
	
	@PostConstruct
	public void init() throws IOException{
		loadConvertersWithId();
		loadFiles();
	}
	
	private void loadConvertersWithId() {
		Map<String, CustomConverter> converters = context.getBeansOfType(CustomConverter.class);
		mapper.setCustomConvertersWithId(converters);
	}
	
	private void loadFiles() throws IOException{
		List<String> mappingFileUrlList = new ArrayList<>();
	    for (Resource resource : resources) {
	        mappingFileUrlList.add(String.valueOf(resource.getURL()));
	    }
	    mapper.setMappingFiles(mappingFileUrlList);
	}
}
