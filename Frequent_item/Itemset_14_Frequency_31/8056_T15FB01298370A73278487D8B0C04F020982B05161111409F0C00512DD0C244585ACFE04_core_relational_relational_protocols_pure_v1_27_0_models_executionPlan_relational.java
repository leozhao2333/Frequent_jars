package org.finos.legend.pure.generated;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.support.coreinstance.*;
import org.eclipse.collections.api.block.function.Function2;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.support.map.PureMap;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function;
import org.finos.legend.pure.m3.execution.ExecutionSupport;
import org.eclipse.collections.impl.factory.Maps;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.support.*;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.support.function.defended.*;
import org.finos.legend.pure.runtime.java.compiled.generation.processors.support.function.*;
import org.finos.legend.pure.runtime.java.compiled.execution.*;
import org.finos.legend.pure.runtime.java.compiled.execution.sourceInformation.*;
public class core_relational_relational_protocols_pure_v1_27_0_models_executionPlan_relational
{
    public static MutableMap<String, SharedPureFunction<?>> __functions = Maps.mutable.empty();
    static
    {
        __functions.put("meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalTdsInstantiationExecutionNode$1", new DefaultPureLambdaFunction1<org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalTdsInstantiationExecutionNode, java.lang.Boolean>()
{
     public java.lang.Boolean execute(ListIterable<?> vars, ExecutionSupport es)
     {
         return value((org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalTdsInstantiationExecutionNode)CompiledSupport.makeOne(vars.get(0)), es);
     }

     public java.lang.Boolean value(final org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalTdsInstantiationExecutionNode _this, final ExecutionSupport es)
     {
return org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_TDSResultType.class.isInstance(_this._resultType());
     }
}
);
        __functions.put("meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalDataTypeInstantiationExecutionNode$1", new DefaultPureLambdaFunction1<org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalDataTypeInstantiationExecutionNode, java.lang.Boolean>()
{
     public java.lang.Boolean execute(ListIterable<?> vars, ExecutionSupport es)
     {
         return value((org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalDataTypeInstantiationExecutionNode)CompiledSupport.makeOne(vars.get(0)), es);
     }

     public java.lang.Boolean value(final org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalDataTypeInstantiationExecutionNode _this, final ExecutionSupport es)
     {
return org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_DataTypeResultType.class.isInstance(_this._resultType());
     }
}
);
        __functions.put("meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalRelationDataInstantiationExecutionNode$1", new DefaultPureLambdaFunction1<org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalRelationDataInstantiationExecutionNode, java.lang.Boolean>()
{
     public java.lang.Boolean execute(ListIterable<?> vars, ExecutionSupport es)
     {
         return value((org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalRelationDataInstantiationExecutionNode)CompiledSupport.makeOne(vars.get(0)), es);
     }

     public java.lang.Boolean value(final org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalRelationDataInstantiationExecutionNode _this, final ExecutionSupport es)
     {
return org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationResultType.class.isInstance(_this._resultType());
     }
}
);
        __functions.put("meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalClassInstantiationExecutionNode$1", new DefaultPureLambdaFunction1<org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalClassInstantiationExecutionNode, java.lang.Boolean>()
{
     public java.lang.Boolean execute(ListIterable<?> vars, ExecutionSupport es)
     {
         return value((org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalClassInstantiationExecutionNode)CompiledSupport.makeOne(vars.get(0)), es);
     }

     public java.lang.Boolean value(final org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_RelationalClassInstantiationExecutionNode _this, final ExecutionSupport es)
     {
return org.finos.legend.pure.generated.Root_meta_protocols_pure_v1_27_0_metamodel_executionPlan_ClassResultType.class.isInstance(_this._resultType());
     }
}
);
    }
}