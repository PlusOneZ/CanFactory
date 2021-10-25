package Manufacturing.ProductLine;

/**
* 生产线总接口
*
* @author 孟繁霖
* @date 2021-10-25 15:06
*/
public interface ProductLine {

    /**
    * 获取具体生产线的名字（如appleLine,peachLine等）
    * @return : java.lang.String
    * @author 孟繁霖
    * @date 2021-10-25 15:05
    */
    String getConcreteName();

}
