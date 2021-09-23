package co.com.micha3l.vega.generator.ms.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import co.com.micha3l.vega.generator.ms.template.Template;

public class TemplateReader {

	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateReader.class);

	public void read(Template template) {

		LOGGER.trace("template: {}", template.getAbsolutName());

		try {

			var file = ResourceUtils.getFile(template.getAbsolutName());
			var inputStream = new FileInputStream(file);
			var resultStringBuilder = new StringBuilder();

			try (var br = new BufferedReader(new InputStreamReader(inputStream))) {

				String line;
				while ((line = br.readLine()) != null) {
					resultStringBuilder.append(line).append("\n");
				}

				LOGGER.trace("contenido: {}", resultStringBuilder);

			} catch (IOException e) {
				LOGGER.error("IOException: {}", e.getMessage(), e);
			}

		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException: {}", e.getMessage(), e);
		}

	}

}
