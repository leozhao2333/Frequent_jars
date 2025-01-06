/**
 * This class was generated by Smooks EJC (http://www.smooks.org).
 */
package org.milyn.edi.unedifact.d17a.BMISRM;

import java.io.Serializable;    
import org.milyn.smooks.edi.EDIWritable;    
import org.milyn.edi.unedifact.d17a.common.PSDPhysicalSampleDescription;    
import java.util.List;    
import org.milyn.edi.unedifact.d17a.common.LOCPlaceLocationIdentification;    
import java.io.Writer;    
import org.milyn.edisax.model.internal.Delimiters;    
import java.io.IOException;    

public class SegmentGroup8 implements Serializable, EDIWritable {

    private static final long serialVersionUID = 1L;

    private PSDPhysicalSampleDescription pSDPhysicalSampleDescription;
    private List<LOCPlaceLocationIdentification> lOCPlaceLocationIdentification;
    private List<SegmentGroup9> segmentGroup9;

    public void write(Writer writer, Delimiters delimiters) throws IOException {
        
        Writer nodeWriter = writer;

        if(pSDPhysicalSampleDescription != null) {
            nodeWriter.write("PSD");
            nodeWriter.write(delimiters.getField());
            pSDPhysicalSampleDescription.write(nodeWriter, delimiters);
        }
        if(lOCPlaceLocationIdentification != null && !lOCPlaceLocationIdentification.isEmpty()) {
            for(LOCPlaceLocationIdentification lOCPlaceLocationIdentificationInst : lOCPlaceLocationIdentification) {
                nodeWriter.write("LOC");
                nodeWriter.write(delimiters.getField());
                lOCPlaceLocationIdentificationInst.write(nodeWriter, delimiters);
            }
        }
        if(segmentGroup9 != null && !segmentGroup9.isEmpty()) {
            for(SegmentGroup9 segmentGroup9Inst : segmentGroup9) {
                segmentGroup9Inst.write(nodeWriter, delimiters);
            }
        }
    }

    public PSDPhysicalSampleDescription getPSDPhysicalSampleDescription() {
        return pSDPhysicalSampleDescription;
    }

    public SegmentGroup8 setPSDPhysicalSampleDescription(PSDPhysicalSampleDescription pSDPhysicalSampleDescription) {
        this.pSDPhysicalSampleDescription = pSDPhysicalSampleDescription;  return this;
    }

    public List<LOCPlaceLocationIdentification> getLOCPlaceLocationIdentification() {
        return lOCPlaceLocationIdentification;
    }

    public SegmentGroup8 setLOCPlaceLocationIdentification(List<LOCPlaceLocationIdentification> lOCPlaceLocationIdentification) {
        this.lOCPlaceLocationIdentification = lOCPlaceLocationIdentification;  return this;
    }

    public List<SegmentGroup9> getSegmentGroup9() {
        return segmentGroup9;
    }

    public SegmentGroup8 setSegmentGroup9(List<SegmentGroup9> segmentGroup9) {
        this.segmentGroup9 = segmentGroup9;  return this;
    }
}