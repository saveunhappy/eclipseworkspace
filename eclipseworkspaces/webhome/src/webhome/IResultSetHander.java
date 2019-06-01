package webhome;

import java.sql.ResultSet;

public interface IResultSetHander<T> {
	T handle(ResultSet rs) throws Exception;
}
