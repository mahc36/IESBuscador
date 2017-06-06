package bussiness.ies;

import java.util.List;

import dto.Filter;
import dto.IesDTO;

public interface IIesBussiness {

	List<IesDTO> getIes();

	List<IesDTO> getIesbyFilter(Filter filter);

	List<IesDTO> findIES(String name);

}
