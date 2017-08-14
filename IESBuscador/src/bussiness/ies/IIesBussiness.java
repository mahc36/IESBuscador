package bussiness.ies;

import java.util.List;

import dto.Filter;
import dto.IesDTO;

public interface IIesBussiness {

	List<Filter> getIes();

	List<Filter> findIES(String name);

	IesDTO getInfo(int iesid);

}
