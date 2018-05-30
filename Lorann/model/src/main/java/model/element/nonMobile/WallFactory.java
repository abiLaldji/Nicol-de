package model.element.nonMobile;

public class WallFactory {
	
	public Wall getWall(String wallType) {
		if(wallType == null){
	         return null;
	      }		
	      if(wallType.equalsIgnoreCase("HBONE")){
	         return new HBone();
	         
	      } else if(wallType.equalsIgnoreCase("VBONE")){
	         return new VBone();
	         
	      } else if(wallType.equalsIgnoreCase("BONE")){
	         return new Bone();
	      }
		return null;
	}
}
