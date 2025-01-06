package org.finos.legend.pure.generated;
import org.finos.legend.pure.generated.*;
public class PureEnum extends Root_meta_pure_metamodel_type_Enum_Impl implements Comparable<org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.type.Enum>{
    private String fullSystemPath;
    
    PureEnum(String id, String enumerationFullName)
    {
        super(id);
        this._name = id;
        this.fullSystemPath = "Root::" + enumerationFullName;
    }
    @Override
    public int compareTo(org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.type.Enum o)
    {
        return this.getName().compareTo(o.getName());
    }
    @Override
    public String getFullSystemPath()
    {
         return this.fullSystemPath;
    }
}
