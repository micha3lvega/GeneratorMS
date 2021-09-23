package co.com.micha3l.vega.generator.ms.template;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objecto que representa las propiedades de un template
 *
 * @author Micha3lVega
 *
 */
@Data
@NoArgsConstructor
public class Template implements Serializable {

	private String basePath = "classpath:\\files\\proyect\\src\\";

	private String path;
	private String name;

	public Template(String name) {
		this.name = name;
		path = "";
	}

	public Template(String path, String name) {
		this.path = path;
		this.name = name;
	}

	public String getAbsolutName() {
		return basePath + path + name;
	}

}
