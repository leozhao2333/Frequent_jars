package org.finos.legend.pure.generated;
import org.finos.legend.pure.generated.*;
import org.finos.legend.pure.m4.coreinstance.SourceInformation;
import org.finos.legend.pure.runtime.java.compiled.metadata.MetadataLazy;
import org.finos.legend.pure.runtime.java.compiled.serialization.model.Obj;
import org.eclipse.collections.api.map.ImmutableMap;

public class PureEnum_LazyImpl extends Root_meta_pure_metamodel_type_Enum_LazyImpl implements Comparable<org.finos.legend.pure.m3.coreinstance.meta.pure.metamodel.type.Enum>{
    private final String fullSystemPath;
    PureEnum_LazyImpl(Obj obj, MetadataLazy metadataLazy)
    {
        super(obj, metadataLazy);
        this.fullSystemPath = "Root::" + obj.getClassifier();
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
